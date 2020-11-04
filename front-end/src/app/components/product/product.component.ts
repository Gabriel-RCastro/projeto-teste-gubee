import {ProductService} from './../../services/product.service';
import {Component, OnInit} from '@angular/core';

import {Product} from 'src/app/models/product.model';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products: Product[];
  stacks: any[];

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.getProducts();
  }

  getProducts() {
    return this.productService.getProducts()
      .subscribe(dados => this.products = dados);
  }

  getProductsByStack(name: string) {
  }

  getProductsByTarget(name: string) {
  }

}
