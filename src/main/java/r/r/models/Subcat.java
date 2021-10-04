package r.r.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Subcat {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int id;
   String name;
   String image;

   @ManyToOne
   Category category;

   @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
   @JoinColumn(name = "subcat_id")
   List<Childcat> childcats;

   public Subcat() {
   };

   public Subcat(String name, String image, Category category) {
      this.name = name;
      this.image = image;
      this.category = category;
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getImage() {
      return this.image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public Category getCategory() {
      return this.category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   public List<Childcat> getChildcats() {
      return this.childcats;
   }

   public void setChildcats(List<Childcat> childcats) {
      this.childcats = childcats;
   }

}
