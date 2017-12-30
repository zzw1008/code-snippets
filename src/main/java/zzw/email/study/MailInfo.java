package zzw.email.study;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
/**
 * 发送邮件类：可发给多人、附带多个附件
 * @author zzw
 *
 */
public class MailInfo {

	/** 邮件发送方 */
	private String sender;

	/** 邮件发送方密码 */
	private String password;

	/** 发送邮件的主机 */
	private String host;

	/** 邮件接受方 */
	private List<String> receivers;

	/** 邮件主题 */
	private String subject;

	/** 邮件正文 */
	private String content;

	/** 附件地址 */
	private List<String> attachments;

	/**
	 * 发送普通文本邮件
	 * @param mi 邮件发送类
	 */
	public void sendTextEmail(MailInfo mi) {

		// 发件人电子邮箱
		String sender = mi.getSender();
		// 企业QQ邮件服务器
		String host = mi.getHost();
		// 获取系统属性
		Properties properties = System.getProperties();
		// 设置邮件服务器
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.auth", "true");
		// 使用ssl验证
		MailSSLSocketFactory sf;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.socketFactory", sf);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}

		// 获取默认session对象
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, mi.getPassword());
			}
		});

		try {
			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);

			// 发件人信息
			message.setFrom(new InternetAddress(sender));

			// 多个收件人
			List<String> temp = mi.getReceivers();
			List<InternetAddress> list = new ArrayList<InternetAddress>();
			for (String l : temp) {
				list.add(new InternetAddress(l));
			}
			InternetAddress[] address = list.toArray(new InternetAddress[list.size()]);

			message.setRecipients(Message.RecipientType.TO, address);

			// 邮件主题
			message.setSubject(mi.getSubject());

			// 邮件内容
			// MimeMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart multiPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart bodyPart = new MimeBodyPart();
			// 设置html邮件消息内容
			bodyPart.setText(mi.getContent());
			multiPart.addBodyPart(bodyPart);

			// 添加附件
			if (mi.getAttachments().size() > 0) {
				for (String attachFile : mi.getAttachments()) {
					bodyPart = new MimeBodyPart();
					// 得到数据源
					FileDataSource fds = new FileDataSource(attachFile);
					// 得到附件本身并放入BodyPart
					bodyPart.setDataHandler(new DataHandler(fds));
					try {
						bodyPart.setFileName(MimeUtility.encodeText(fds.getName(), "UTF-8", "B"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					// 得到文件名并编码（防止中文文件名乱码）同样放入BodyPart
					multiPart.addBodyPart(bodyPart);
				}
			}

			// 设置邮件消息的主要内容
			message.setContent(multiPart);

			// 发送消息
			Transport.send(message);
			System.out.println("发送成功");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	/**
	 * 发送html格式邮件
	 * @param mi 邮件发送类
	 */
	public void sendHtmlEmail(MailInfo mi) {
		// 发件人电子邮箱
		String sender = mi.getSender();
		// 企业QQ邮件服务器
		String host = mi.getHost();
		// 获取系统属性
		Properties properties = System.getProperties();
		// 设置邮件服务器
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.auth", "true");
		// 使用ssl验证
		MailSSLSocketFactory sf;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.socketFactory", sf);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}

		// 获取默认session对象
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, mi.getPassword());
			}
		});

		try {
			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);

			// 发件人信息
			message.setFrom(new InternetAddress(sender));

			// 多个收件人
			List<String> temp = mi.getReceivers();
			List<InternetAddress> list = new ArrayList<InternetAddress>();
			for (String l : temp) {
				list.add(new InternetAddress(l));
			}
			InternetAddress[] address = list.toArray(new InternetAddress[list.size()]);

			message.setRecipients(Message.RecipientType.TO, address);

			// 邮件主题
			message.setSubject(mi.getSubject());

			// 邮件内容
			// MimeMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart multiPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart bodyPart = new MimeBodyPart();
			// 设置html邮件消息内容
			bodyPart.setContent(mi.getContent(), "text/html; charset=utf-8");
			multiPart.addBodyPart(bodyPart);

			// 添加附件
			if (mi.getAttachments().size() > 0) {
				for (String attachFile : mi.getAttachments()) {
					bodyPart = new MimeBodyPart();
					// 得到数据源
					FileDataSource fds = new FileDataSource(attachFile);
					// 得到附件本身并放入BodyPart
					bodyPart.setDataHandler(new DataHandler(fds));
					try {
						bodyPart.setFileName(MimeUtility.encodeText(fds.getName(), "UTF-8", "B"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					System.out.println(fds.getName());
					// 得到文件名并编码（防止中文文件名乱码）同样放入BodyPart
					multiPart.addBodyPart(bodyPart);
				}
			}

			// 设置邮件消息的主要内容
			message.setContent(multiPart);

			// 发送消息
			Transport.send(message);
			System.out.println("发送成功");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public List<String> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<String> receivers) {
		this.receivers = receivers;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<String> attachments) {
		this.attachments = attachments;
	}

}
