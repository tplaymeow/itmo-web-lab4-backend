package com.tplaymeow.itmoweblab4backend.Beans;

import com.tplaymeow.itmoweblab4backend.DBModels.ResultDB;
import com.tplaymeow.itmoweblab4backend.DBModels.UserDB;
import com.tplaymeow.itmoweblab4backend.Models.CheckResponse;
import com.tplaymeow.itmoweblab4backend.Models.Coordinates;
import com.tplaymeow.itmoweblab4backend.Models.Result;
import com.tplaymeow.itmoweblab4backend.Rest.AuthFilter.UserPrincipal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ResultsBean {
    @PersistenceContext(unitName = "persistence-unit")
    private EntityManager entityManager;

    public CheckResponse check(Coordinates coordinates, UserPrincipal userPrincipal) {
        Query namedQuery = entityManager.createNamedQuery("UserDB.findByID");
        namedQuery.setParameter("id", userPrincipal.getId());
        UserDB user = (UserDB) namedQuery.getSingleResult();

        Boolean success = true;

        ResultDB result = ResultDB.builder()
                .x(coordinates.getX())
                .y(coordinates.getY())
                .r(coordinates.getR())
                .success(success)
                .timestamp(LocalDateTime.now())
                .owner(user)
                .build();

        entityManager.persist(result);

        return new CheckResponse(success);
    }

    public List<Result> getResults(UserPrincipal userPrincipal) {
        try {
            Query namedQuery = entityManager.createNamedQuery("UserDB.findByIDWithResults");
            namedQuery.setParameter("id", userPrincipal.getId());
            UserDB user = (UserDB) namedQuery.getSingleResult();
            return user.getResults().stream()
                    .sorted(Comparator.comparing(ResultDB::getTimestamp))
                    .map(ResultsBean::transformToResult)
                    .collect(Collectors.toList());
        } catch (PersistenceException exception) {
            return new ArrayList<>();
        }
    }

    private static Result transformToResult(ResultDB db) {
        return new Result(
                db.getId(),
                db.getX(),
                db.getY(),
                db.getR(),
                db.getTimestamp().toString(),
                db.getSuccess()
        );
    }
}
