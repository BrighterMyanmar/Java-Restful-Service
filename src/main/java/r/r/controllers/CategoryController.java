package r.r.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import r.r.dtos.CatDto;
import r.r.models.Category;
import r.r.services.CatService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/cats")
public class CategoryController {

   private CatService catService;

   public CategoryController(CatService catService) {
      this.catService = catService;
   }

   @GetMapping
   public List<Category> all() {
      return catService.all();
   }

   @GetMapping("{id}")
   public Category getSingleCat(@PathVariable int id) {
      return catService.get(id);
   }

   @PostMapping
   public Category save(@RequestParam("name") String name, @RequestParam("image") MultipartFile file) {
      CatDto catDto = new CatDto(name, file);
      return catService.save(catDto);
   }

   @PutMapping("{id}")
   public Category update(@PathVariable("id") int id, @RequestParam("name") String name,
         @RequestParam("image") MultipartFile file) {
      CatDto catDto = new CatDto(name, file);
      return catService.update(id, catDto);
   }

   @DeleteMapping("{id}")
   public String delete(@PathVariable int id) {
      catService.delete(id);
      return "Category Delete Success";
   }

}
