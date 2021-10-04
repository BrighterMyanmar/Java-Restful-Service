package r.r.impls;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import r.r.dtos.CatDto;
import r.r.models.Category;
import r.r.repos.CatRepo;
import r.r.services.CatService;
import r.r.services.ImageUploadService;

@Service
@Transactional
public class CatImpl implements CatService {

   private CatRepo catRepo;
   private ImageUploadService imageUploadService;

   public CatImpl(CatRepo catRepo, ImageUploadService imageUploadService) {
      this.catRepo = catRepo;
      this.imageUploadService = imageUploadService;
   }

   @Override
   public Category save(CatDto catDto) {
      Category cat = new Category();
      cat.setName(catDto.getName());
      cat.setImage(imageUploadService.saveFile(catDto.getFile()));
      return catRepo.save(cat);
   }

   @Override
   public List<Category> all() {
      return catRepo.findAll();
   }

   @Override
   public Category get(int id) {
      return catRepo.findById(id).orElse(null);
   }

   // PUT , Patch
   @Override
   public Category update(int id, CatDto catDto) {
      Category cat = catRepo.findById(id).orElse(null);
      cat.setName(catDto.getName());
      cat.setImage(imageUploadService.saveFile(catDto.getFile()));
      return catRepo.save(cat);
   }

   @Override
   public void delete(int id) {
      Category cat = catRepo.findById(id).orElse(null);
      catRepo.delete(cat);

   }

}
