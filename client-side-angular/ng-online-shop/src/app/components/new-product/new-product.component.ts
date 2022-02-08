import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IProduct } from 'src/app/models/IProduct.interface';

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent implements OnInit {

  product:IProduct= {
    id:0,
    description:'',
    price:0,
    category:'',
    imageUrl:'' 
  };

  constructor(
    // public prodService:ProductsService, 
    private router:Router,
    private route: ActivatedRoute) {
    let id = this.route.snapshot.paramMap.get('id');
    // if (id) this.prodService.getProduct(id).subscribe(data => this.product = data);
  }

  // formValidate = new FormGroup({
  //   description: new FormControl('',Validators.required),
  //   price: new FormControl('',[
  //     Validators.required,
  //     ProductValidators.minPrice
  //   ]),
  //   category: new FormControl('',Validators.required),
  //   imageUrl: new FormControl('',[
  //     Validators.required,
  //     Validators.pattern('(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})[/\\w .-]*/?')
  //   ])
  // })

  ngOnInit(): void {
  }

  // saveProduct(product){
  //   if(this.product.id === 0){
  //       this.prodService.createProduct(product.value).subscribe(
  //         data => {
  //           product.reset();
  //           if(data){
              
  //           }
  //         } 
  //         //this.router.navigate([''])

  //       );
  //   }
  //     else {
  //       this.prodService.updateProduct(this.product).subscribe();
  //     }

  // }

  // get description(){
  //   return this.formValidate.get('description');
  // }

  // get price(){
  //   return this.formValidate.get('price');
  // }

  // get category(){
  //   return this.formValidate.get('category');
  // }

  // get imageUrl(){
  //   return this.formValidate.get('imageUrl');
  // }

}
