package com.spring.boot.blog.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
/**
 * @className Blog.java
 * @author Nuri
 * @date Apr 1, 2019 7:47:31 PM   
*/
@Entity
public class Blog implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 主键ID
	
	@NotEmpty(message = "标题不能为空")
	@Size(min=2, max=50)
	@Column(nullable = false, length = 50) // 映射为字段，值不能为空
	private String title;
	
	@NotEmpty(message = "摘要不能为空")
	@Size(min=2, max=300)
	@Column(nullable = false) // 映射为字段，值不能为空
	private String summary;

	@Lob  // 大对象，映射 MySQL 的 Long Text 类型
	@Basic(fetch=FetchType.LAZY) // 懒加载
	@NotEmpty(message = "内容不能为空")
	@Size(min=2)
	@Column(nullable = false) // 映射为字段，值不能为空
	private String content;
	
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(nullable = false) // 映射为字段，值不能为空
	@org.hibernate.annotations.CreationTimestamp  // 由数据库自动创建时间
	private Timestamp createTime;
	
	protected Blog() {

	}
	
	public Blog(String title, String summary,String content) {
		this.title = title;
		this.summary = summary;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
}

