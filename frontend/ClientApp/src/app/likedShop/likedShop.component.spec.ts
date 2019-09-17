import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { likedShopComponent } from './likedShop.component';

describe('ShopComponent', () => {
  let component: likedShopComponent;
  let fixture: ComponentFixture<likedShopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ likedShopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(likedShopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
