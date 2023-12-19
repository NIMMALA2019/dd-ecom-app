package com.ntreddy.dd.ecommerce.constants;

public class PathConstants {

    public static final String API_V1 = "/api/v1";
    public static final String CATALOG = "/catalog";
    public static final String ORDER = "/order";
    public static final String ORDERS = "/orders";
    public static final String CATEGORY = "/categories";
    public static final String PRODUCTS = "/products";
    public static final String PRODUCT_ID = "/{productId}";
    public static final String CART_ID = "/{cartId}";
    public static final String REVIWES = "/reviews";
    public static final String ALL = "/all";
    public static final String PERFUMES = "/perfumes";
    public static final String USER = "/user";
    public static final String GRAPHQL = "/graphql";
    public static final String UPLOAD = "/upload";
    public static final String ID = "/{id}";

    public static final String API_V1_ADMIN = API_V1 + "/admin";
    public static final String API_V1_AUTH = API_V1 + "/auth";
    public static final String API_V1_ORDER = API_V1 + ORDER;
    public static final String API_V1_PERFUMES = API_V1 + PERFUMES;
    public static final String API_V1_REGISTRATION = API_V1 + "/registration";
    public static final String API_V1_REVIEW = API_V1 + "/review";
    public static final String API_V1_USERS = API_V1 + "/users";

    public static final String ADD = "/add";
    public static final String EDIT = "/edit";
    public static final String DELETE = "/delete";
    public static final String CART = "/cart";
    public static final String DELETE_BY_PERFUME_ID = "/delete/{perfumeId}";
    public static final String ORDER_BY_EMAIL = ORDER + "/{userEmail}";
    public static final String ORDER_DELETE = ORDER + "/delete/{orderId}";
    public static final String USER_BY_ID = USER + "/{userId}";
    public static final String USER_ALL = USER + "/all";
    public static final String GRAPHQL_USER = GRAPHQL + USER;
    public static final String GRAPHQL_USER_ALL = GRAPHQL + USER + "/all";
    public static final String GRAPHQL_ORDERS = GRAPHQL + ORDERS;
    public static final String GRAPHQL_ORDER = GRAPHQL + ORDER;

    public static final String LOGIN = "/login";
    public static final String FORGOT_EMAIL = "/forgot/{email}";
    public static final String RESET = "/reset";
    public static final String CODE = "/{code}";
    public static final String RESET_CODE = RESET + CODE;
    public static final String ACTIVATE_CODE = "/activate" + CODE;
    public static final String EDIT_PASSWORD = "/edit/password";

    public static final String ORDER_ID = "/{orderId}";
    public static final String ORDER_ID_ITEMS = ORDER_ID + "/items";

    public static final String PERFUME_ID = "/{perfumeId}";
    public static final String IDS = "/ids";
    public static final String SEARCH = "/search";
    public static final String SEARCH_GENDER = SEARCH + "/gender";
    public static final String SEARCH_PERFUMER = SEARCH + "/perfumer";
    public static final String SEARCH_TEXT = SEARCH + "/text";
    public static final String GRAPHQL_IDS = GRAPHQL + IDS;
    public static final String GRAPHQL_PERFUMES = GRAPHQL + PERFUMES;
    public static final String GRAPHQL_PERFUME = GRAPHQL + "/perfume";
    
    public static final String ADMIN = "/admin";
    //coupon
    public static final String COUPON = "/coupon" ;
    public static final String API_V1_COUPON = API_V1_ADMIN + COUPON;
    
    
    
    //
//    public static final String API_V1_TECHG_INFO_CONTACT = API_V1+TECHG_INFO  +"/Contactinfo";
    public static final String TECHG_INFO = "/techG";
    public static final String API_V1_TECHG_INFO_CONTACT = API_V1 + TECHG_INFO + "/contactinfo";
    
    
}
