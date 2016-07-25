package com.qjk.scheduled;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.qjk.data.Sms;
import com.qjk.service.ISmsService;
import com.qjk.util.SmsUtil;

@Component
public class ScheduledTask {
	
	Logger logger= Logger.getLogger(ScheduledTask.class);

	@Resource
	private ISmsService smsService;

	/**
	 * 心跳更新。启动时执行一次，之后每隔2秒执行一次
	 */
//	@Scheduled(fixedRate = 1000 * 10)
	public void smsSend() {
		int[] status = { 0 };
		try {
			List<Sms> smsList = smsService.querySmsList(status);

			if (smsList != null && smsList.size() > 0) {

				for (Sms sms : smsList) {
					try {
						sms = SmsUtil.sendSms(sms);
						smsService.updateSms(sms);
					} catch (UnsupportedEncodingException e) {
						logger.error(e.getMessage());
					}
				}

			}

		} catch (Exception e) {

			logger.error(e.getMessage());
		}
	}

	public static void main(String[] args) {
	}
}
