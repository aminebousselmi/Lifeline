package com.lifeline.api.homeconfig.service;

import com.lifeline.api.homeconfig.dto.SectionDTO;
import com.lifeline.api.homeconfig.utility.exceptions.custom.HomeConfigNotFoundException;
import com.lifeline.api.homeconfig.utility.exceptions.custom.InvalidUUIDSignatureException;

public interface SectionService {
    SectionDTO add(SectionDTO sectionDTO);
    SectionDTO getByUID(String uid) throws HomeConfigNotFoundException, InvalidUUIDSignatureException;
    SectionDTO editByUID(String uid, SectionDTO sectionDTO) throws HomeConfigNotFoundException, InvalidUUIDSignatureException;
    // FIXME DELETE SECTION
}
