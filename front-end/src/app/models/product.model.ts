import {Stack} from './stack.model';
import {Target} from './target.model';

export interface Product {
  id: number;
  productName: string;
  description: string;
  targetMarket: Target[];
  stack: Stack[];
}
