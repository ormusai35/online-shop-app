import { FormControl } from "@angular/forms";

export class ProductValidator {
    
    static minPrice(control: FormControl){
        return control.value > 0 ? null : { minprice: true }
    }

}