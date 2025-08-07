package com.example.tasks;

import java.util.concurrent.Callable;

import com.example.dao.MOffersDao;
import com.example.model.Offers;
import com.example.model.TaskResult;

public class MOffersTask implements Callable<TaskResult> {

	private String cardnum;

	public MOffersTask(String cardnum) {
		this.cardnum = cardnum;
	}

	@Override
	public TaskResult call() throws Exception {
		
		System.out.println("Entered into MOffers task");

		MOffersDao dao = new MOffersDao();
		Offers moffers = dao.getOffers(cardnum);
		TaskResult taskResult = new TaskResult();
		taskResult.setTaskName("mtask");
		taskResult.setResult(moffers);

		System.out.println("Exit from MOffers task");

		
		return taskResult;
	}

}
