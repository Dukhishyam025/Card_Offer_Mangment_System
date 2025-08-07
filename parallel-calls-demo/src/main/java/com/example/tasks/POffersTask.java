package com.example.tasks;

import java.util.concurrent.Callable;

import com.example.dao.POffersDao;
import com.example.model.Offers;
import com.example.model.TaskResult;

public class POffersTask implements Callable<TaskResult> {

	private String cardnum;

	public POffersTask(String cardnum) {
		this.cardnum = cardnum;
	}

	@Override
	public TaskResult call() throws Exception {

		System.out.println("Entered into POffers task");

		POffersDao dao = new POffersDao();
		Offers poffers = dao.getOffers(cardnum);
		TaskResult taskResult = new TaskResult();
		taskResult.setTaskName("ptask");
		taskResult.setResult(poffers);

		System.out.println("Exit from POffers task");

		return taskResult;
	}

}
