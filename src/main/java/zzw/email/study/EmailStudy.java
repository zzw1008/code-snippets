package zzw.email.study;

import java.util.ArrayList;
import java.util.List;

/**
 * 发送邮件demo
 * @author zzw
 * @date 2017年10月24日 下午3:04:01
 *
 */
public class EmailStudy {
	public static void main(String[] args) {
		MailInfo mi = new MailInfo();
		mi.setSender("zhangzhengwei@segasoft.cn");
		mi.setHost("smtp.exmail.qq.com");
		mi.setPassword("Z20170822w!");
		//接收方 主题 内容  附件内容
		List<String> receivers = new ArrayList<String>();
		receivers.add("2246287065@qq.com");
		receivers.add("1371748893@qq.com");
		mi.setReceivers(receivers);
		
		mi.setSubject("hello");
		
		mi.setContent("<strong>hello</strong>");
		
		List<String> attachments = new ArrayList<String>();
		attachments.add("C:\\Users\\黄\\Desktop\\新建 Microsoft Word 文档.docx");
		attachments.add("C:\\Users\\黄\\Desktop\\新建文本文档.txt");
		mi.setAttachments(attachments);
		mi.sendHtmlEmail(mi);
		
	}
}
