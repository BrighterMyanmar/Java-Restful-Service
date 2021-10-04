package r.r.dtos;

import org.springframework.web.multipart.MultipartFile;

public class CatDto {
   String name;
   MultipartFile file;

   public CatDto() {
   }

   public CatDto(String name, MultipartFile file) {
      this.name = name;
      this.file = file;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public MultipartFile getFile() {
      return this.file;
   }

   public void setFile(MultipartFile file) {
      this.file = file;
   }

}
