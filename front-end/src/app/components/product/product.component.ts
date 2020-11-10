import { ProductService } from './../../services/product.service';
import { Component, OnInit } from '@angular/core';

import { Product } from 'src/app/models/product.model';
import { Stack } from 'src/app/models/stack.model';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products: Product[];
  stacks: Stack[];
  txtSearch;

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
    if (name && (name = name.trim()) !== '') {
      return this.productService.getProductsByStack(name)
        .subscribe(dados => this.products = dados);
    } else {
      this.getProducts();
    }
  }

  getProductsByTargetMarket(name: string) {
    if (name && (name = name.trim()) !== '') {
      return this.productService.getProductsByTargetMarket(name)
        .subscribe(dados => this.products = dados);
    } else {
      this.getProducts();
    }
  }
}
