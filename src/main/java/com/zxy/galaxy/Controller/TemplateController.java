package com.zxy.galaxy.Controller;

import com.zxy.galaxy.Common.Result;
import org.springframework.web.bind.annotation.RestController;

/**
 * 视频例子参考用
 */
@RestController
public class TemplateController {
    public Result list(Integer currentPage) {
        return Result.success(null);
    }
}
