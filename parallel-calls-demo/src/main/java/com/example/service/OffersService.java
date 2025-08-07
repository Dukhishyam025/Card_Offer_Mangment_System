package com.example.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.example.model.Offers;
import com.example.model.TaskResult;
import com.example.tasks.GOffersTask;
import com.example.tasks.MOffersTask;
import com.example.tasks.POffersTask;

public class OffersService {

	public List<Offers> getOffers(String cardNum) throws InterruptedException, ExecutionException {

		List<Offers> offersList = new ArrayList<Offers>();

		Offers finalOffers = new Offers();

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		Set tasks = new HashSet();

		tasks.add(new GOffersTask(cardNum));
		tasks.add(new POffersTask(cardNum));
		tasks.add(new MOffersTask(cardNum));
		
		System.out.println("before invoking parallel calls");

		// execute 3 tasks by 3 threads paralley and hold all threads response by Future
		// object
		List<Future<TaskResult>> futureList = executorService.invokeAll(tasks);

		for (Future future : futureList) {

			TaskResult tr = (TaskResult) future.get();

			if ("gtask".equals(tr.getTaskName())) {

				Offers gOffers = (Offers) tr.getResult();

				Offers gserviceOffers = new Offers();
				gserviceOffers.setDesc(gOffers.getDesc());
				gserviceOffers.setExpDate(gOffers.getExpDate());
				gserviceOffers.setImageUrl(gOffers.getImageUrl());
				gserviceOffers.setName(gOffers.getName());
				gserviceOffers.setOid(gOffers.getOid());

				offersList.add(gserviceOffers);

			} else if ("ptask".equals(tr.getTaskName())) {

				Offers pOffers = (Offers) tr.getResult();
				
				Offers pserviceOffers = new Offers();
				
				pserviceOffers.setDesc(pOffers.getDesc());
				pserviceOffers.setExpDate(pOffers.getExpDate());
				pserviceOffers.setImageUrl(pOffers.getImageUrl());
				pserviceOffers.setName(pOffers.getName());
				pserviceOffers.setOid(pOffers.getOid());

				offersList.add(pserviceOffers);

			} else {

				Offers mOffers = (Offers) tr.getResult();
				
				Offers mserviceOffers = new Offers();

				mserviceOffers.setDesc(mOffers.getDesc());
				mserviceOffers.setExpDate(mOffers.getExpDate());
				mserviceOffers.setImageUrl(mOffers.getImageUrl());
				mserviceOffers.setName(mOffers.getName());
				mserviceOffers.setOid(mOffers.getOid());
				
				offersList.add(mserviceOffers);

			}

		}

		return offersList;

	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		OffersService offersService = new OffersService();
		
		List<Offers> offersList = offersService.getOffers("244535346435");
		
		System.out.println("offersList are " + offersList);
	}

}
