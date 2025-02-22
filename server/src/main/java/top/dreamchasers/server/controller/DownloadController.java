package top.dreamchasers.server.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
@RequestMapping("/download")
public class DownloadController {

    @Value("${download.base-path}")
    private String fileBasePath;

    @GetMapping("/**")
    public ResponseEntity<FileSystemResource> downloadFile(HttpServletRequest request) {
        String fullPath = request.getRequestURI().replace(request.getContextPath() + "/download/", "");

        String filePath = fileBasePath + fullPath.replace("/", File.separator);

        File file = new File(filePath);

        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }

        FileSystemResource resource = new FileSystemResource(file);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());
        headers.add(HttpHeaders.CONTENT_TYPE, "application/octet-stream");

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }

}
