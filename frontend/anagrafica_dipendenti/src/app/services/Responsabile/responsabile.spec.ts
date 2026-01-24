import { TestBed } from '@angular/core/testing';

import { ResponsabileService } from './responsabile.service';

describe('Responsabile', () => {
  let service: ResponsabileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResponsabileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
