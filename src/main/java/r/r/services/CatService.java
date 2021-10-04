package r.r.services;

import java.util.List;

import org.springframework.stereotype.Service;

import r.r.dtos.CatDto;
import r.r.models.Category;

@Service
public interface CatService {
   Category save(CatDto catDto); // Save

   List<Category> all(); // all

   Category get(int id); // get

   Category update(int id, CatDto catDto); // update

   void delete(int id); // delete
   // patch

}
