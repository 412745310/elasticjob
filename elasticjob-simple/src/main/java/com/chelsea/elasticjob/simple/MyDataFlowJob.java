package com.chelsea.elasticjob.simple;

import java.util.ArrayList;
import java.util.List;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;

/**
 * Dataflow类型作业
 * 
 * @author shevchenko
 *
 */
public class MyDataFlowJob implements DataflowJob<String> {

	/*
	 * status 0：待处理 1：已处理
	 */

	@Override
	public List<String> fetchData(ShardingContext shardingContext) {
		List<String> users = new ArrayList<String>();
		users.add("user1");
		users.add("user2");
		users.add("user3");
		/**
		 * users = SELECT * FROM user WHERE status = 0 AND MOD(id,
		 * shardingTotalCount) = shardingItem Limit 0, 30
		 */
		return users;
	}

	@Override
	public void processData(ShardingContext shardingContext, List<String> data) {
		for (String user : data) {
			System.out.println(String.format("用户 %s 开始计息", user));
			/**
			 * update user
			 */
		}
	}

}
