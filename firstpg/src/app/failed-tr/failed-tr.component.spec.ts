import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FailedTrComponent } from './failed-tr.component';

describe('FailedTrComponent', () => {
  let component: FailedTrComponent;
  let fixture: ComponentFixture<FailedTrComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FailedTrComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FailedTrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
