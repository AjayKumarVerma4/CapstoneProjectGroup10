import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuByRestaurantComponent } from './menu-by-restaurant.component';

describe('MenuByRestaurantComponent', () => {
  let component: MenuByRestaurantComponent;
  let fixture: ComponentFixture<MenuByRestaurantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuByRestaurantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuByRestaurantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
