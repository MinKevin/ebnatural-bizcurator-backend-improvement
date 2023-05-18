package ebnatural.bizcurator.apiserver.service;

import ebnatural.bizcurator.apiserver.common.exception.custom.CategoryNotFoundException;
import ebnatural.bizcurator.apiserver.common.exception.custom.ErrorCode;
import ebnatural.bizcurator.apiserver.common.exception.custom.InvalidDocumentTypeException;
import ebnatural.bizcurator.apiserver.domain.Category;
import ebnatural.bizcurator.apiserver.domain.MakeDocument;
import ebnatural.bizcurator.apiserver.domain.PurchaseDocument;
import ebnatural.bizcurator.apiserver.domain.PurposeCategory;
import ebnatural.bizcurator.apiserver.domain.constant.DocumentType;
import ebnatural.bizcurator.apiserver.dto.request.PurchaseMakeDocumentRequest;
import ebnatural.bizcurator.apiserver.dto.request.SellDocumentRequest;
import ebnatural.bizcurator.apiserver.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DocumentService {
    private final CategoryRepository categoryRepository;
    private final PurchaseDocumentRepository purchaseDocumentRepository;
    private final MakeDocumentRepository makeDocumentRepository;
    private final SellDocumentRepository sellDocumentRepository;
    private final PurposeCategoryRepository purposeCategoryRepository;


    public void postPurchaseMakeDocument(PurchaseMakeDocumentRequest docDto) {
        if (docDto.getDocumentType().equals(String.valueOf(DocumentType.make))){
            PurposeCategory purposeCategory = purposeCategoryRepository.findById(docDto.getCategory())
                    .orElseThrow(() -> new CategoryNotFoundException());
            makeDocumentRepository.save(MakeDocument.of(docDto, purposeCategory));
        }
        else if(docDto.getDocumentType().equals(String.valueOf(DocumentType.purchase))){
            Category category = categoryRepository.findById(docDto.getCategory())
                    .orElseThrow(() -> new CategoryNotFoundException());
            purchaseDocumentRepository.save(PurchaseDocument.of(docDto, category));
        }
        else
            throw new InvalidDocumentTypeException(ErrorCode.INVALID_DOCUMENT_TYPE_EXCEPTION);
    }

    public void postSellDocument(SellDocumentRequest docDto) {
    }
}
