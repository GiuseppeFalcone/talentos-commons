package com.certimetergroup.easycv.commons.enumeration;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@AllArgsConstructor
public enum UserRoleEnum {
    SUPERADMIN(List.of(GET, POST, PUT, PATCH, DELETE)),
    ADMIN(List.of(GET, PUT, PATCH, DELETE)),
    MANAGER(List.of(GET, PUT, PATCH)),
    EMPLOYEE(List.of(GET));

    public final List<RequestMethod> requestMethodList;
}