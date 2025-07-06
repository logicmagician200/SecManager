package xyz.supersec.secmanager.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.websocket.server.PathParam;
import xyz.supersec.secmanager.handler.CreateNewTaskHander;

@Controller
@RequestMapping("/upload/v1")
public class UploadController {
    @Autowired
    private CreateNewTaskHander createNewTaskHander;

    // 处理文件上传的逻辑
    @GetMapping("/{msId}/file")
    public ResponseEntity<String> uploadFileGet(@PathVariable("msId") int msId) {

        System.out.println("====================================================");

        createNewTaskHander.createAsmTask(msId);




        // 文件上传逻辑
        return ResponseEntity.ok("File uploaded successfully: ");
    }
    // 处理文件上传的逻辑
    @PostMapping("/{msId}/secscanner/file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,@PathParam("msId") int msId) {

        createNewTaskHander.createAsmTask(msId);




        // 文件上传逻辑
        return ResponseEntity.ok("File uploaded successfully: " + file.getOriginalFilename());
    }

    // 处理图片上传的逻辑
    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile image) {
        // 图片上传逻辑
        return ResponseEntity.ok("Image uploaded successfully: " + image.getOriginalFilename());
    }



    
    
}
