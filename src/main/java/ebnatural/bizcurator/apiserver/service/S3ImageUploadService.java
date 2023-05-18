package ebnatural.bizcurator.apiserver.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import ebnatural.bizcurator.apiserver.common.exception.custom.ImageUploadException;
import ebnatural.bizcurator.apiserver.common.exception.custom.NotImageFileException;
import ebnatural.bizcurator.apiserver.common.util.ConvertDataType;
import lombok.RequiredArgsConstructor;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class S3ImageUploadService {
    private final AmazonS3 amazonS3Client;
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    /**
     * S3에 파일 업로드
     *
     * @param multipartFile
     * @return
     * @throws IOException
     */
    public String uploadImage(String dir, MultipartFile multipartFile) {
        String newFileName = changeFileName(dir, multipartFile);

        try {
            String fileType = checkFileType(multipartFile);

            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(fileType);

            amazonS3Client.putObject(new PutObjectRequest(bucket, newFileName, multipartFile.getInputStream(), objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException exception) {
            throw new ImageUploadException();
        }

        return amazonS3Client.getUrl(bucket, newFileName).toString();
    }

    /**
     * S3에서 파일 삭제
     *
     * @param fileName
     */
    public void deleteFile(String fileName) {
        amazonS3Client.deleteObject(bucket, fileName);
    }

    /**
     * 파일 타입 확인
     *
     * @param multipartFile
     * @return fileType
     */
    public String checkFileType(MultipartFile multipartFile) throws IOException {
        try {
            String fileType = new Tika().detect(multipartFile.getInputStream());

            // MIME타입이 이미지가 아니면 exception 발생
            if (!fileType.startsWith("image/")) {
                throw new NotImageFileException();
            }

            return fileType;
        } catch (IOException exception) {
            throw new ImageUploadException();
        }
    }

    /**
     * '업로드날짜_파일이름'로 파일 이름 변경
     *
     * @param multipartFile
     * @return
     */
    public String changeFileName(String dir, MultipartFile multipartFile) {

        return dir +
                "/" +
                ConvertDataType.dateFormatter(LocalDate.now()) +
                "_" +
                multipartFile.getOriginalFilename();
    }
}
