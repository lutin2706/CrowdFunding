import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowProjetComponent } from './show-projet.component';

describe('ShowProjetComponent', () => {
  let component: ShowProjetComponent;
  let fixture: ComponentFixture<ShowProjetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowProjetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowProjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
