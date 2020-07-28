import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PassTrComponent } from './pass-tr.component';

describe('PassTrComponent', () => {
  let component: PassTrComponent;
  let fixture: ComponentFixture<PassTrComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PassTrComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PassTrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
