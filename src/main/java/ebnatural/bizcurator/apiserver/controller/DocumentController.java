package ebnatural.bizcurator.apiserver.controller;

import ebnatural.bizcurator.apiserver.common.exception.custom.ErrorCode;
import ebnatural.bizcurator.apiserver.common.exception.custom.InvalidDocumentTypeException;
import ebnatural.bizcurator.apiserver.domain.constant.DocumentType;
import ebnatural.bizcurator.apiserver.dto.request.PurchaseMakeDocumentRequest;
import ebnatural.bizcurator.apiserver.dto.request.SellDocumentRequest;
import ebnatural.bizcurator.apiserver.dto.response.CommonResponse;
import ebnatural.bizcurator.apiserver.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/requests")
public class DocumentController {
    private final DocumentService documentService;

    @PostMapping("/orders")
    public ResponseEntity<CommonResponse> postPurchaseMakeDocument (@RequestBody PurchaseMakeDocumentRequest docDto){
        documentService.postPurchaseMakeDocument(docDto);
        return CommonResponse.ok(HttpStatus.OK.value(), "post document success");
    }

    @PostMapping("/partners")
    public ResponseEntity<CommonResponse> postSellDocument (@RequestBody SellDocumentRequest docDto){
        documentService.postSellDocument(docDto);
        return CommonResponse.ok(HttpStatus.OK.value(), "post document success");
    }
}
