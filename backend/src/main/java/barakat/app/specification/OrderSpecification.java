package barakat.app.specification;

import barakat.app.entity.Order;
import barakat.tctransport.model.gen.QCustomers;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class OrderSpecification implements Specification<Order> {

    public static Specification<Order> getClientName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.join("bkCustomer").get("name")), "%"+name.toLowerCase() + "%");
    }

    public static Specification<Order> getProductName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.join("bkProduct").get("name")), "%"+name.toLowerCase() + "%");
    }

    public static Specification<Order> ignoreStatuses(List<String> nonstatuses) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.not(criteriaBuilder.in(root.get("status")).value(nonstatuses));//not().in()
    }


    private List<SearchCriteria> list = new ArrayList<>();

    public void add(SearchCriteria criteria) {
        list.add(criteria);
    }


    @Override
    public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();

        for (SearchCriteria criteria : list) {
            if(criteria.getJoin() == null){
                switch (criteria.getOperation()) {
                    case GREATER_THAN:
                        predicates.add(builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString()));
                        break;
                    case LESS_THAN:
                        predicates.add(builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
                        break;
                    case GREATER_THAN_EQUAL:
                        predicates.add(builder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
                        break;
                    case LESS_THAN_EQUAL:
                        predicates.add(builder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
                        break;
                    case NOT_EQUAL:
                        predicates.add(builder.notEqual(root.get(criteria.getKey()), criteria.getValue()));
                        break;
                    case EQUAL:
                        predicates.add(builder.equal(root.get(criteria.getKey()), criteria.getValue()));
                        break;
                    case LIKE:
                        predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase() + "%"));
                        break;
                    case LIKE_END:
                        predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), criteria.getValue().toString().toLowerCase() + "%"));
                        break;
                    case LIKE_START:
                        predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase()));
                        break;
                    case IN:
                        predicates.add(builder.in(root.get(criteria.getKey())).value(criteria.getValue()));
                        break;
                    case NOT_IN:
                        predicates.add(builder.not(root.get(criteria.getKey())).in(criteria.getValue()));
                        break;
                }
            }else{
                switch (criteria.getOperation()) {
                    case LIKE:
                        predicates.add(builder.like(builder.lower(root.join(criteria.getJoin()).get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase() + "%"));
                        break;
                }
            }
        }
        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
