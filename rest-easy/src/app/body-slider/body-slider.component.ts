import { Component, OnInit } from '@angular/core';
import { SliderImage } from '../model/slider.image';

@Component({
  selector: 'app-body-slider',
  templateUrl: './body-slider.component.html',
  styleUrls: ['./body-slider.component.css']
})
export class BodySliderComponent implements OnInit {

  arr:Array<SliderImage>=[
    {"imageURL":"https://smash-images.photobox.com/original/5f04c1b41fd48d1b10ff27dfc90548bf13608845_Large-Print-lifestyle-3_1-2600.jpg",
    "header":"Alfred Stieglitz",
    "content":"In photography there is a reality so subtle that it becomes more real than reality."},
    {"imageURL":"https://smash-images.photobox.com/original/bca8e5fa7862a2cfaefc300c5b572e7a6dc6f3f3_Standard-Prints-lifestyle-3_1-2600.jpg",
    "header":"Ralph Hattersley",
    "content":"We are making photographs to understand what our lives mean to us."},
    {"imageURL":"https://smash-images.photobox.com/original/a422aed1a721e933961b19ea9e47e07fc71e0699_Acrylic-Prints-lifestyle-3_1-2600.jpg",
    "header":"Robert Frank",
    "content":"There is one thing the photograph must contain, the humanity of the moment."},
   ];
  constructor() { }

  ngOnInit(): void {
  }

}
