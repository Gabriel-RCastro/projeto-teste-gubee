import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../models/product.model';

import { Observable } from 'rxjs';
import { distinct, distinctUntilChanged, map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { ppid } from 'process';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private readonly API = environment.API;

  constructor(private http: HttpClient) {
  }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.API}/products`).pipe(
      distinctUntilChanged((prev, curr) => prev.filter(p => p.productName) !== curr.filter(c => c.productName))
    );
  }

  getProductsByStack(name: string) {
    return this.myFilter('stack', name);
  }

  getProductsByTargetMarket(name: string) {
    return this.myFilter('targetMarket', name);
  }

  private myFilter(tableName: string, name: string) {
    return this.http.get<Product[]>(`${this.API}/products/byFilter/${this.toFilter(tableName)}/${name}`);
  }

  private toFilter(tableName: string) {
    var filter = 'STACK';
    if (tableName == 'targetMarket') {
      filter ='TARGET_MARKET';
    }
    return filter;
  }
}
