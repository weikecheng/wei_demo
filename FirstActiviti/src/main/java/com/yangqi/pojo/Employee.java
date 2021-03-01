/**
 * 
 */
package com.yangqi.pojo;

import java.io.Serializable;

/**
* @author YangQi
* @version 创建时间：<br>
*				   2018年8月14日 上午10:22:12
* @ClassName 类名称<br>
* @Description 类描述<br>
*/
public class Employee implements Serializable {
	
	//职员姓名
	private String employeeName;
	
	//请假天数
	private int day;
	
	//请假状态
	private boolean leaveStatus = false;
	
	//结果状态
	private boolean ResultStatus = false;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public boolean isLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(boolean leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public boolean isResultStatus() {
		return ResultStatus;
	}

	public void setResultStatus(boolean resultStatus) {
		ResultStatus = resultStatus;
	}

}
