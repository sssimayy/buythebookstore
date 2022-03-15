package com.buythebookstore.core.check;

import com.buythebookstore.core.results.Result;
import com.buythebookstore.core.results.SuccessResult;

import java.util.List;

public class CheckResult {
    public static Result checkResult(List<Result> results) {
        for (Result result : results) {
            if (!result.isSuccess()) {
                return result;
            }
        }
        return new SuccessResult();
    }
}
