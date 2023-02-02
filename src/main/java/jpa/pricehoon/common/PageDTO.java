package jpa.pricehoon.common;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@RequiredArgsConstructor
@AllArgsConstructor// final인 애들만 생성자가 나옴 = 그냥 DI할 때 막써서 몰랐음..ㅎㅎ
public class PageDTO {

    private final Integer currentPage;

    private final Integer size;

    private String sortBy;

    public Pageable toPageable(){
        return PageRequest.of(currentPage-1,size, Sort.by(sortBy).descending());
    }
}
