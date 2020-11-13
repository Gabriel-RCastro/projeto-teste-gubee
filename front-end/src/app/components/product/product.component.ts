import { ProductService } from './../../services/product.service';
import { Component, OnInit } from '@angular/core';

import { Product } from 'src/app/models/product.model';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  private readonly URL = `${environment.BASE_URL}/products`;

  products: Product[];

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.getProducts();
  }

  getProducts() {
    return this.productService.getProducts(this.URL)
      .subscribe(dados => this.products = dados);
  }

  getProductsByFilter(productName: string, selectedOption: string) {
    if (productName && (productName = productName.trim()) !== '') {
      return this.productService.getProducts(`${this.URL}/byFilter/${selectedOption}/${productName}`)
        .subscribe(dados => this.products = dados);
    }
    return this.getProducts();
  }
}
