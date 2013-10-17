package com.gm.osoa.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String[] VCODE={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private static final String[] VFONT={"Times New Roman","Arial","Verdana","Georgia","Courier New"};
    private static final int[] VCHAR={Font.PLAIN, Font.ITALIC};
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		// 在内存中创建图象
		int width = 70, height = 20;
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);

		// 获取图形上下文
		Graphics g = image.getGraphics();

		// 生成随机类
		Random random = new Random();

		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		// 设定字体
		g.setFont(new Font(VFONT[0], VCHAR[0], 18));

		// 画边框
		// g.setColor(new Color());
		// g.drawRect(0,0,width-1,height-1);

		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// 取随机产生的认证码(4位数字)
		StringBuffer sRand = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(VCODE[random.nextInt(36)]);
			sRand.append(rand);
			// 将认证码显示到图象中
			//设置字体
			g.setFont(new Font(VFONT[random.nextInt(5)], VCHAR[random.nextInt(2)], 18));
			// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.setColor(new Color(random.nextInt(130), random.nextInt(130), random.nextInt(130)));
			g.drawString(rand, 13 * i + 10, 18);
		}

		// 将认证码存入SESSION
		request.getSession().setAttribute("vc", sRand.toString());

		// 图象生效
		g.dispose();
		OutputStream output = response.getOutputStream();
		
		// 输出图象到页面
		ImageIO.write(image, "JPEG", response.getOutputStream());
		output.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	
	private Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

}
