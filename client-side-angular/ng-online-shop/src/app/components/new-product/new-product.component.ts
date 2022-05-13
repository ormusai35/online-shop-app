import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { IProduct } from 'src/app/models/IProduct.interface';
import { ProductsService } from 'src/app/services/products.service';
import { ProductValidator } from 'src/app/validators/ProductValidors.validators';

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent implements OnInit {

  product: IProduct= {
    id:0,
    description:'',
    price:0,
    category:'',
    imageUrl:'' 
  };

  formValidate = new FormGroup({
    description: new FormControl('',Validators.required),
    price: new FormControl('',[Validators.required, ProductValidator.minPrice]),
    category: new FormControl('',Validators.required),
    imageUrl: new FormControl('',[
      Validators.required
      ,
      // Validators.pattern('(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})[/\\w .-]*/?')
      Validators.pattern('https?://.+')
    ])
  })

  constructor(
    public prodService:ProductsService, 
    private router:Router,
    private route: ActivatedRoute) {
    let id = this.route.snapshot.paramMap.get('id');
    console.log(id)
    if (id) this.prodService.getProduct(id).subscribe(data => this.product = data);
  }



  ngOnInit(): void {
    console.log(this.route.snapshot.paramMap.get("id"))
  }

  saveProduct(formProduct: FormGroup){

    if(this.product.id === 0){
        this.prodService.createProduct(formProduct.value).subscribe(
          data => {
            formProduct.reset();
            if(data){
            }
          } 
          //this.router.navigate([''])

        );
    }
      else {
        this.prodService.updateProduct(this.product).subscribe();
        formProduct.reset();
      }

  }

  get description(){
    return this.formValidate.get('description');
  }

  get price(){
    return this.formValidate.get('price');
  }

  get category(){
    return this.formValidate.get('category');
  }

  get imageUrl(){
    return this.formValidate.get('imageUrl');
  }

}
