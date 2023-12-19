package com.ntreddy.dd.ecommerce.util;

import java.util.Objects;

public final class Pagination {

    private final long page;

    private final long size;

    public Pagination(long page, long size) {
        this.page = page;
        this.size = size;
    }


    public long getLimit() {
        return size;
    }

    public long getOffset() {
        return (page - 1) * size;
    }

    public Pagination next() {
        return Pagination.of(page + 1, size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pagination page1 = (Pagination) o;
        return page == page1.page && size == page1.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, size);
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }

    public static Pagination of(long page, long size) {
        if (page <= 0) {
            throw new IllegalArgumentException("The page cannot be either zero or negative");
        } else if (size <= 0) {
            throw new IllegalArgumentException("The size cannot be either zero or negative");
        }
        return new Pagination(page, size);
    }

}
