package com.barclays.offers.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.barclays.offers.exception.BusinessException;
import com.barclays.offers.exception.SystemException;
import com.barclays.offers.model.OfferDetailsDao;
import com.barclays.offers.model.OffersDaoRequest;
import com.barclays.offers.model.OffersDaoResponse;
import com.barclays.offers.util.OfferDetailsConstant;
import com.barclays.offers.util.OfferDetailsEnum;

@Component
public class MOffersDaoImpl implements IOffersDao {

	@Override
	public OffersDaoResponse getOffers(OffersDaoRequest daoRequest) throws BusinessException, SystemException {

		// 1.get the request from service

		// 2.prepare the request for database

		// 3.call database and get the response

		OffersDaoResponse offersDaoResponse = new OffersDaoResponse();
		try {

			Class.forName(OfferDetailsConstant.DRIVER_CLASS);

			Connection connection = DriverManager.getConnection(OfferDetailsConstant.DB_URL,
					OfferDetailsConstant.USERNAME, OfferDetailsConstant.PASSWORD);

			String sp = OfferDetailsConstant.SP_CALL;

			CallableStatement cstmt = connection.prepareCall(sp);

			cstmt.setString(1, daoRequest.getClientId());
			cstmt.setString(2, daoRequest.getChannelId());
			cstmt.setString(3, daoRequest.getCardNum());
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.registerOutParameter(5, Types.VARCHAR);

			cstmt.execute();
			ResultSet rs = cstmt.executeQuery();

			String dbRespCode = cstmt.getString(4);
			String dbRespMsg = cstmt.getString(5);

			List<OfferDetailsDao> offerDaoList = new ArrayList<OfferDetailsDao>();

			if (OfferDetailsConstant.SUCCESS_RESP_CODE.equals(dbRespCode)) {

				while (rs.next()) {
					OfferDetailsDao offerDetailsDao = new OfferDetailsDao();
					offerDetailsDao.setOfferId(rs.getString(1));
					offerDetailsDao.setName(rs.getString(2));
					offerDetailsDao.setImageUrl(rs.getString(3));
					offerDetailsDao.setDesc(rs.getString(4));
					offerDetailsDao.setOfferType(rs.getString(5));
					offerDetailsDao.setStdate(rs.getString(6));
					offerDetailsDao.setEndate(rs.getString(7));
					offerDetailsDao.setStatus(rs.getString(8));
					offerDetailsDao.setRemarks(rs.getString(9));
					offerDaoList.add(offerDetailsDao);

				}

//				OfferDetailsDao offerDetailsDao1 = new OfferDetailsDao();
//				offerDetailsDao1.setDate("14-06-2025");
//				offerDetailsDao1.setDesc("good");
//				offerDetailsDao1.setImageUrl("");
//				offerDetailsDao1.setName("Oneplus 12R");
//				offerDetailsDao1.setOfferId("23534");
//				offerDetailsDao1.setStatus("Active");
//
//				OfferDetailsDao offerDetailsDao2 = new OfferDetailsDao();
//				offerDetailsDao2.setDate("14-06-2025");
//				offerDetailsDao2.setDesc("good");
//				offerDetailsDao2.setImageUrl("");
//				offerDetailsDao2.setName("Oneplus 12R");
//				offerDetailsDao2.setOfferId("23534");
//				offerDetailsDao2.setStatus("Active");
//
//				OfferDetailsDao offerDetailsDao3 = new OfferDetailsDao();
//				offerDetailsDao3.setDate("14-06-2025");
//				offerDetailsDao3.setDesc("good");
//				offerDetailsDao3.setImageUrl("");
//				offerDetailsDao3.setName("Oneplus 12R");
//				offerDetailsDao3.setOfferId("23534");
//				offerDetailsDao3.setStatus("Active");
//
//				offerDaoList.add(offerDetailsDao1);
//				offerDaoList.add(offerDetailsDao2);
//				offerDaoList.add(offerDetailsDao3);
//
				offersDaoResponse.setOfferDaoList(offerDaoList);
				offersDaoResponse.setRespCode(dbRespCode);
				offersDaoResponse.setRespMsg(dbRespMsg);

			} else if (OfferDetailsEnum.checkErrorCode(dbRespCode, OfferDetailsConstant.DATA_ERROR)) {

				throw new BusinessException(dbRespCode, dbRespMsg);

			} else if (OfferDetailsEnum.checkErrorCode(dbRespCode, OfferDetailsConstant.SYSTEM_ERROR)) {

				throw new SystemException(dbRespCode, dbRespMsg);

			} else {
				throw new SystemException(OfferDetailsConstant.DB_UNKNOWN_ERROR_CODE,
						OfferDetailsConstant.DB_KNOWN_ERROR_MSG);
			}
		} catch (BusinessException be) {
			be.printStackTrace();
			throw be;
		} catch (SystemException se) {
			se.printStackTrace();
			throw se;
		} catch (Exception se) {

			se.printStackTrace();
			throw new SystemException(OfferDetailsConstant.DB_UNKNOWN_ERROR_CODE,
					OfferDetailsConstant.DB_KNOWN_ERROR_MSG);
		}

		return offersDaoResponse;

	}

}
