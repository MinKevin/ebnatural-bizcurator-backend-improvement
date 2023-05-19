package ebnatural.bizcurator.apiserver.service;

import ebnatural.bizcurator.apiserver.common.exception.custom.CategoryNotFoundException;
import ebnatural.bizcurator.apiserver.common.exception.custom.ErrorCode;
import ebnatural.bizcurator.apiserver.common.exception.custom.InvalidDocumentTypeException;
import ebnatural.bizcurator.apiserver.common.util.MemberUtil;
import ebnatural.bizcurator.apiserver.domain.*;
import ebnatural.bizcurator.apiserver.domain.constant.DocumentType;
import ebnatural.bizcurator.apiserver.dto.PurchaseMakeDocumentDto;
import ebnatural.bizcurator.apiserver.dto.SellDocumentDto;
import ebnatural.bizcurator.apiserver.dto.request.PurchaseMakeDocumentRequest;
import ebnatural.bizcurator.apiserver.dto.request.SellDocumentRequest;
import ebnatural.bizcurator.apiserver.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DocumentService {
    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;
    private final PurchaseDocumentRepository purchaseDocumentRepository;
    private final MakeDocumentRepository makeDocumentRepository;
    private final SellDocumentRepository sellDocumentRepository;
    private final PurposeCategoryRepository purposeCategoryRepository;
    private final S3ImageUploadService s3ImageUploadService;

    @Value("${cloud.aws.s3.purchase-document-dir}")
    private String purchaseDir;
    @Value("${cloud.aws.s3.make-document-dir}")
    private String makeDir;
    @Value("${cloud.aws.s3.sell-document-dir}")
    private String sellDir;

    public void postPurchaseMakeDocument(PurchaseMakeDocumentRequest docDto, MultipartFile image) {
        Member member = memberRepository.findByUserId(MemberUtil.getMemberId());
        if (docDto.getDocumentType().equals(String.valueOf(DocumentType.make))) {
            PurposeCategory purposeCategory = purposeCategoryRepository.findById(docDto.getCategory())
                    .orElseThrow(() -> new CategoryNotFoundException());
            String storedPath = s3ImageUploadService.uploadImage(makeDir, image);
            makeDocumentRepository.save(MakeDocument.of(member, docDto, purposeCategory, storedPath));
        } else if (docDto.getDocumentType().equals(String.valueOf(DocumentType.purchase))) {
            Category category = categoryRepository.findById(docDto.getCategory())
                    .orElseThrow(() -> new CategoryNotFoundException());
            String storedPath = s3ImageUploadService.uploadImage(purchaseDir, image);
            purchaseDocumentRepository.save(PurchaseDocument.of(member, docDto, category, storedPath));
        } else
            throw new InvalidDocumentTypeException(ErrorCode.INVALID_DOCUMENT_TYPE_EXCEPTION);
    }

    public void postSellDocument(SellDocumentRequest docDto, MultipartFile image) {
        Member member = memberRepository.findByUserId(MemberUtil.getMemberId());
        Category category = categoryRepository.findById(docDto.getCategory())
                .orElseThrow(() -> new CategoryNotFoundException());
        String storedPath = s3ImageUploadService.uploadImage(sellDir, image);
        sellDocumentRepository.save(SellDocument.of(member, docDto, category, storedPath));
    }

    public List<PurchaseMakeDocumentDto> getPurchaseMakeDocuments(Long memberId) {
        List<PurchaseMakeDocumentDto> purchaseMakeDocumentDtoList = new ArrayList<>();
        List<PurchaseMakeDocumentDto> purchaseDocumentDtoList =
                memberId == null ?
                        Optional.of(purchaseDocumentRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                                .stream()
                                .map(entity -> PurchaseMakeDocumentDto.fromPurchase(entity))
                                .collect(Collectors.toList())).get()
                        :
                        Optional.of(purchaseDocumentRepository.findByMemberId(memberId)
                                .stream()
                                .map(entity -> PurchaseMakeDocumentDto.fromPurchase(entity))
                                .collect(Collectors.toList())).get();

        List<PurchaseMakeDocumentDto> makeDocumentDtoList =
                memberId == null ?
                        Optional.of(makeDocumentRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                                .stream()
                                .map(entity -> PurchaseMakeDocumentDto.fromMake(entity))
                                .collect(Collectors.toList())).get()
                        :
                        Optional.of(makeDocumentRepository.findByMemberId(memberId)
                                .stream()
                                .map(entity -> PurchaseMakeDocumentDto.fromMake(entity))
                                .collect(Collectors.toList())).get();


        if (!purchaseDocumentDtoList.isEmpty()) {
            purchaseMakeDocumentDtoList.addAll(purchaseDocumentDtoList);

            if (!makeDocumentDtoList.isEmpty())
                purchaseMakeDocumentDtoList.addAll(makeDocumentDtoList);
        }
        return purchaseMakeDocumentDtoList;
    }

    public List<SellDocumentDto> getSellDocuments(Long memberId) {
        List<SellDocumentDto> sellDocumentDtoList =
                memberId == null ?
                        Optional.of(sellDocumentRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                                .stream()
                                .map(entity -> SellDocumentDto.from(entity))
                                .collect(Collectors.toList())).get()
                        :
                        Optional.of(sellDocumentRepository.findByMemberId(memberId)
                                .stream()
                                .map(entity -> SellDocumentDto.from(entity))
                                .collect(Collectors.toList())).get();

        return sellDocumentDtoList;
    }

    public void updatePurchaseMakeDocument(Long documentId, PurchaseMakeDocumentRequest docDto, MultipartFile image) {
        Member member = memberRepository.findByUserId(MemberUtil.getMemberId());
        if (docDto.getDocumentType().equals(String.valueOf(DocumentType.make))) {
            PurposeCategory purposeCategory = purposeCategoryRepository.findById(docDto.getCategory())
                    .orElseThrow(() -> new CategoryNotFoundException());
            MakeDocument makeDocument = makeDocumentRepository.findById(documentId)
                    .orElseThrow(() -> new EntityNotFoundException());
            if (!image.isEmpty()) {
                String recentPath = makeDocument.getImageDirectory();
                String storedPath = s3ImageUploadService.uploadImage(makeDir, image);
                s3ImageUploadService.deleteFile(recentPath);
                docDto.setImageDirectory(storedPath);
            }
            makeDocument.update(member, purposeCategory, docDto);

        } else if (docDto.getDocumentType().equals(String.valueOf(DocumentType.purchase))) {
            Category category = categoryRepository.findById(docDto.getCategory())
                    .orElseThrow(() -> new CategoryNotFoundException());
            PurchaseDocument purchaseDocument = purchaseDocumentRepository.findById(documentId)
                    .orElseThrow(() -> new EntityNotFoundException());
            if (!image.isEmpty()) {
                String recentPath = purchaseDocument.getImageDirectory();
                String storedPath = s3ImageUploadService.uploadImage(makeDir, image);
                s3ImageUploadService.deleteFile(recentPath);
                docDto.setImageDirectory(storedPath);
            }
            purchaseDocument.update(member, category, docDto);
        } else
            throw new InvalidDocumentTypeException(ErrorCode.INVALID_DOCUMENT_TYPE_EXCEPTION);
    }

    public void updateSellDocument(Long documentId, SellDocumentRequest docDto, MultipartFile image) {
        Member member = memberRepository.findByUserId(MemberUtil.getMemberId());
        Category category = categoryRepository.findById(docDto.getCategory())
                .orElseThrow(() -> new CategoryNotFoundException());
        SellDocument sellDocument = sellDocumentRepository.findById(documentId)
                .orElseThrow(() -> new EntityNotFoundException());
        if (!image.isEmpty()) {
            String recentPath = sellDocument.getImageDirectory();
            String storedPath = s3ImageUploadService.uploadImage(makeDir, image);
            s3ImageUploadService.deleteFile(recentPath);
            docDto.setImageDirectory(storedPath);
        }
        sellDocument.update(member, category, docDto);
    }
}

