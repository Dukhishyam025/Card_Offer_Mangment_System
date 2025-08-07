package com.example.tasks;

import java.util.concurrent.Callable;

import com.example.dao.GOffersDao;
import com.example.model.Offers;
import com.example.model.TaskResult;

public class GOffersTask implements Callable<TaskResult> {

	private String cardnum;

	public GOffersTask(String cardnum) {
		this.cardnum = cardnum;
	}

	@Override
	public TaskResult call() throws Exception {
		
		System.out.println("Entered into GOffers task");

		GOffersDao dao = new GOffersDao();
		Offers goffers = dao.getOffers(cardnum);
		TaskResult taskResult = new TaskResult();
		taskResult.setTaskName("gtask");
		taskResult.setResult(goffers);
		
		System.out.println("Exit from GOffers task");

		return taskResult;
	}

}
