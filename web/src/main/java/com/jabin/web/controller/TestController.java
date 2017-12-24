package com.jabin.web.controller;

import com.google.common.collect.Lists;
import com.jabin.dao.base.SeedTestMapper;
import com.jabin.domain.base.SeedTest;
import com.jabin.web.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * Created by Jabin on 2017/8/24.
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/test")
public class TestController extends BaseController {

    @Autowired
    private SeedTestMapper seedTestMapper;

    @ResponseBody
    @RequestMapping(value = "test1")
    public ModelMap test1() {
        SeedTest seedTest = new SeedTest();
        Random random = new Random();
        int max = 999999999;
        int min = 100000000;
        for (int i = 0; i < 100000000; i++) {
            seedTest.setCharTest(UUID.randomUUID().toString());
            seedTest.setVarcharTest(UUID.randomUUID().toString());
            seedTest.setIntTest(random.nextInt(max) % (max - min + 1) + min);
            seedTestMapper.insert(seedTest);
            System.out.println("插入第" + i + "条数据...success !");
        }
        modelMap.put("哈哈", "是是是");
        return modelMap;
    }

    @ResponseBody
    @RequestMapping(value = "test2")
    public String test() {
        ExecutorService executorService = Executors.newFixedThreadPool(10000);
        List<Future<String>> futures = Lists.newArrayList();
        for (int i = 0; i < 2000; i++) {
            System.out.println("添加第 " + i + "个线程！");
            TestThread testThread = new TestThread(i);
            executorService.submit(testThread);
        }
        for (Future<String> future : futures) {
            try {
                future.get();
            } catch (InterruptedException e) {
            } catch (ExecutionException e) {
            } finally {
                if (!future.isCancelled()) {
                    future.cancel(false);
                }
            }
        }
        return "test";
    }


    /**
     * 下发核算数据主线程
     */
    class TestThread implements Callable<String> {

        private int index;

        TestThread(int index) {
            this.index = index;
        }

        @Override
        public String call() throws Exception {
            SeedTest seedTest = new SeedTest();
            Random random = new Random();
            int max = 999999999;
            int min = 100000000;
            for (int i = 0; i < 50000; i++) {
                seedTest.setCharTest(UUID.randomUUID().toString());
                seedTest.setVarcharTest(UUID.randomUUID().toString());
                seedTest.setIntTest(random.nextInt(max) % (max - min + 1) + min);
                seedTestMapper.insert(seedTest);
                System.out.println("插入第" + index + " - " + i + "条数据...success !");
            }
            return "" + index;
        }
    }
}