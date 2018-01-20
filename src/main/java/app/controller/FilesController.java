package app.controller;


import app.service.AbraKadabra;
import app.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@RestController
public class FilesController {
    @Autowired
    FileService fileService;

    @Autowired
    AbraKadabra abraKadabra;

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/files", method = RequestMethod.GET)
    public List<String> listFilesOfPath(@RequestParam(value = "path", defaultValue = ".") String path) {
        return fileService.getFileNames(path);
    }

    //Client downloads a file
    @RequestMapping(value = "/files/download", method = RequestMethod.GET)
    @ResponseBody
    public void downloadFile(
            @RequestParam(value = "path") String path,
            HttpServletResponse response) {

        File file = new File(path);
        if (!file.exists()) return;
        log.info("Uploading file [{}] to client", file.getAbsolutePath());


        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + path);

        try {
            InputStream is = new FileInputStream(file);
            FileCopyUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Client uploads file
    @RequestMapping(value = "/files/upload", method = RequestMethod.POST)
    @ResponseBody
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        String filename = file.getOriginalFilename();
        log.info("Client uploads file; filename:[{}]", filename);
        try {
            String uri = filename;
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(uri)));
            stream.write(bytes);
            stream.close();
            log.info("Successfully written to [{}]", uri);
        } catch (Exception e) {
            throw new RuntimeException("Error writing to " + filename + ": " + e.getMessage());
        }
    }





}
