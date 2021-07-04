import { Component, OnInit } from '@angular/core';
import { Image } from '../model/images';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  arr:Array<Image>=[
    {"restaurant":"adidas",
      "imageURL":"assets/images/image1.jfif",
      "foodname":"Briyani",
    "content":"Photography is a way of feeling, of touching, of loving. "},
    {"restaurant":"adidas",
      "imageURL":"assets/images/image2.jpg",
      "foodname":"Briyani",
    "content":"Photography is a way of feeling, of touching, of loving. "},
    {"restaurant":"adidas",
    "imageURL":"assets/images/image3.jpg",
    "foodname":"Briyani",
  "content":"Photography is a way of feeling, of touching, of loving. "},
  {"restaurant":"adidas",
  "imageURL":"assets/images/image4.jpg",
  "foodname":"Briyani",
"content":"Photography is a way of feeling, of touching, of loving. "},
{"restaurant":"adidas",
      "imageURL":"assets/images/image5.jpg",
      "foodname":"Briyani",
    "content":"Photography is a way of feeling, of touching, of loving.  "},
    {"restaurant":"adidas",
    "imageURL":"assets/images/image6.jpg",
    "foodname":"Briyani",
  "content":"Photography is a way of feeling, of touching, of loving. "},
  {"restaurant":"adidas",
  "imageURL":"assets/images/image7.jpg",
  "foodname":"Briyani",
"content":"Photography is a way of feeling, of touching, of loving. "},
{"restaurant":"adidas",
      "imageURL":"assets/images/image8.jpg",
      "foodname":"Briyani",
    "content":"Photography is a way of feeling, of touching, of loving. "}
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
