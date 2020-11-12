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

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.getProducts();
  }

  getProducts() {
    return this.productService.getProducts()
      .subscribe(dados => this.products = dados);
  }

  getProductsByFilter(name: string, optionSearch: string) {
    if (name && (name = name.trim()) !== '') {
      switch (optionSearch) {
        case 'stack': return this.getProductsByStack(name);
        case 'target_market': return this.getProductsByTargetMarket(name);
      }
    }
    return this.getProducts();
  }

  private getProductsByStack(name: string) {
    return this.productService.getProductsByStack(name)
      .subscribe(dados => this.products = dados);
  }

  private getProductsByTargetMarket(name: string) {
    return this.productService.getProductsByTargetMarket(name)
      .subscribe(dados => this.products = dados);
  }
}
