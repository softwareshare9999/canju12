/*
 * 一二残局 - 中国象棋残局刷题软件
 * Copyright (C) 2026 刘霸天-长沙
 *
 * 本程序是自由软件：你可以再分发之和/或依照由自由软件基金会发布的
 * GNU 通用公共许可证修改之，无论是版本 3 许可证，还是（按你的决定）任何以后版都可以。
 *
 * 发布该程序是希望它能有用，但是并无保障;甚至连可销售和符合某个特定的目的都不保证。
 * 请参看 GNU 通用公共许可证，了解详情。
 *
 * 你应该随程序获得一份 GNU 通用公共许可证的复本。如果没有，请看 <https://www.gnu.org/licenses/>。
 */

package com.canju12.zhuzicanju;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 轻量级国际化字典。
 *
 * 字典的键始终保留中文原文，值是对应的越南语翻译；默认输出越南语，
 * 当系统语言为中文时回退到字典键（中文）。
 *
 * 棋盘上的棋子图片不参与翻译（棋子图形本身保留中文）。
 */
public final class I18n {

    private static final Map<String, String> VI = new HashMap<>();

    private I18n() {
    }

    /** 系统语言是否为中文。 */
    public static boolean isChinese() {
        return Locale.getDefault().getLanguage().toLowerCase(Locale.ROOT).startsWith("zh");
    }

    /** 翻译一段中文原文；没有对应词条时原样返回。 */
    public static String tr(String zh) {
        if (zh == null || isChinese()) return zh;
        String vi = VI.get(zh);
        return vi != null ? vi : zh;
    }

    /** 先翻译模板，再按 {@link String#format} 填充参数。 */
    public static String tr(String zh, Object... args) {
        return String.format(Locale.ROOT, tr(zh), args);
    }

    static {
        // ==================== MainActivity ====================
        VI.put("未找到题库文件，请检查assets目录", "Không tìm thấy tệp kho câu hỏi, vui lòng kiểm tra thư mục assets");
        VI.put("加载错题失败: 序号无效", "Tải sổ câu sai thất bại: số thứ tự không hợp lệ");
        VI.put("错题本不存在", "Sổ câu sai không tồn tại");
        VI.put("错题序号无效，共 %d 题", "Số thứ tự câu sai không hợp lệ, tổng cộng %d câu");
        VI.put("加载错题失败", "Tải sổ câu sai thất bại");
        VI.put("已加载错题本第 %d 题", "Đã tải câu %d trong sổ câu sai");
        VI.put("存储权限已授予", "Đã cấp quyền lưu trữ");
        VI.put("需要存储权限才能管理题库文件", "Cần quyền lưu trữ để quản lý tệp kho câu hỏi");
        VI.put("错题本.txt文件已创建", "Đã tạo tệp sổ câu sai (.txt)");
        VI.put("创建文件夹失败: %s", "Tạo thư mục thất bại: %s");
        VI.put("诗词库为空，请检查 strings.xml", "Thư viện thơ trống, vui lòng kiểm tra strings.xml");
        VI.put("暂无可用诗句", "Chưa có câu thơ nào");
        VI.put("🔥🔥刘霸天为您加油🔥🔥", "🔥🔥Lưu Bá Thiên cổ vũ bạn🔥🔥");
        VI.put("🔥🔥刘霸天为您加油🔥🔥🔥", "🔥🔥Lưu Bá Thiên cổ vũ bạn🔥🔥🔥");
        VI.put("🔥🔥刘霸天为您加油！🔥🔥🔥", "🔥🔥Lưu Bá Thiên cổ vũ bạn!🔥🔥🔥");
        VI.put("🔥刘霸天为您加油！🔥🔥", "🔥Lưu Bá Thiên cổ vũ bạn!🔥🔥");
        VI.put("未选择题库", "Chưa chọn kho câu hỏi");
        VI.put("题库为空", "Kho câu hỏi trống");
        VI.put("已是题库中第一题！", "Đã là câu đầu tiên trong kho!");
        VI.put("知道了", "Đã hiểu");
        VI.put("是", "Có");
        VI.put("否", "Không");
        VI.put("QQ群：635808985 · 1003608168 · 94846686", "Nhóm QQ: 635808985 · 1003608168 · 94846686");
        VI.put("出现重复局面，请变招", "Xuất hiện thế cờ lặp lại, hãy đổi nước");
        VI.put("🎉 你赢了！进入下一题", "🎉 Bạn đã thắng! Chuyển sang câu tiếp theo");
        VI.put("🤖 你输了！是否重来？", "🤖 Bạn đã thua! Có thử lại không?");
        VI.put("🎉 红方胜利！进入下一题", "🎉 Đỏ thắng! Chuyển sang câu tiếp theo");
        VI.put("黑方胜利！", "Đen thắng!");
        VI.put("yyyy年MM月dd日", "dd/MM/yyyy");
        VI.put("第 %d/%d 题", "Câu %d/%d");
        VI.put("已完成", "Đã hoàn thành");
        VI.put("请选择题库", "Hãy chọn kho câu hỏi");
        VI.put("进度/正确率：%d/%d (%d%%)", "Tiến độ/Độ chính xác: %d/%d (%d%%)");
        VI.put("本题用时：%02d:%02d | 总用时：%02d:%02d", "Thời gian câu này: %02d:%02d | Tổng thời gian: %02d:%02d");
        VI.put("🎉 已完成所有题目！", "🎉 Đã hoàn thành tất cả câu hỏi!");
        VI.put("连续多题局面不合法，已停止", "Nhiều thế cờ liên tiếp không hợp lệ, đã dừng");
        VI.put("第%d题局面不合法：%s，即将跳到下一题", "Thế cờ câu %d không hợp lệ: %s, sẽ chuyển sang câu tiếp theo");
        VI.put("📚 选择题库", "📚 Chọn kho câu hỏi");
        VI.put("共 %d 个题库", "Tổng cộng %d kho câu hỏi");
        VI.put("错题本不可删除", "Không thể xóa sổ câu sai");
        VI.put("不可隐藏不可删除", "Không thể ẩn hoặc xóa");
        VI.put("隐藏题库", "Ẩn kho câu hỏi");
        VI.put("确定隐藏内置题库「%s」吗？", "Bạn có chắc muốn ẩn kho câu hỏi tích hợp “%s” không?");
        VI.put("隐藏", "Ẩn");
        VI.put("取消", "Hủy");
        VI.put("已隐藏", "Đã ẩn");
        VI.put("删除题库", "Xóa kho câu hỏi");
        VI.put("确定删除外置题库「%s」吗？", "Bạn có chắc muốn xóa kho câu hỏi bên ngoài “%s” không?");
        VI.put("删除", "Xóa");
        VI.put("已删除", "Đã xóa");
        VI.put("确定隐藏内置题库「%s」吗？可在刷新后重新显示。", "Bạn có chắc muốn ẩn kho câu hỏi tích hợp “%s” không? Có thể hiển thị lại sau khi làm mới.");
        VI.put("刷新", "Làm mới");
        VI.put("已刷新", "Đã làm mới");
        VI.put("关闭", "Đóng");
        VI.put("加载题库失败", "Tải kho câu hỏi thất bại");
        VI.put("加载第 %d 题", "Đang tải câu %d");
        VI.put("请先选择题库", "Vui lòng chọn kho câu hỏi trước");
        VI.put("共 %d 题", "Tổng cộng %d câu");
        VI.put("🔄 重置进度", "🔄 Đặt lại tiến độ");
        VI.put("⚠️ 重置进度", "⚠️ Đặt lại tiến độ");
        VI.put("确定要重置 \"%s\" 的进度吗？\n\n所有已完成题目将被标记为未完成，此操作不可撤销！", "Bạn có chắc muốn đặt lại tiến độ của \"%s\" không?\n\nTất cả câu đã hoàn thành sẽ bị đánh dấu là chưa hoàn thành. Thao tác này không thể hoàn tác!");
        VI.put("重置", "Đặt lại");
        VI.put("进度已重置", "Đã đặt lại tiến độ");
        VI.put("棋盘未初始化", "Bàn cờ chưa được khởi tạo");
        VI.put("FEN已复制到剪贴板", "Đã sao chép FEN vào clipboard");
        VI.put("已回到当前题目的初始局面", "Đã trở về thế cờ ban đầu của câu này");
        VI.put("悔棋成功", "Đã hoàn tác nước đi");
        VI.put("已回到最初局面", "Đã trở về thế cờ ban đầu");
        VI.put("标记为：不会 - 已记录到错题本", "Đã đánh dấu: Không biết - Đã ghi vào sổ câu sai");
        VI.put("标记为：已会", "Đã đánh dấu: Đã biết");
        VI.put("AI启动失败:\n%s", "Khởi động AI thất bại:\n%s");
        VI.put("皮卡鱼报错：%s", "Pikafish báo lỗi: %s");
        VI.put("双方可和棋（你执红，未过关），是否重来？", "Hai bên có thể hòa (bạn cầm Đỏ, chưa vượt qua), có thử lại không?");
        VI.put("双方可和棋（你执黑，算过关）", "Hai bên có thể hòa (bạn cầm Đen, tính là vượt qua)");
        VI.put("错题本中已存在", "Đã có trong sổ câu sai");
        VI.put("已记录到错题本", "Đã ghi vào sổ câu sai");
        VI.put("再接再厉！", "Cố gắng lên!");
        VI.put("！是否重来？", "! Có thử lại không?");
        VI.put("🔥🔥刘霸天为您加油！🔥🔥🔥\n☁️☁️云库为您加油！☁️☁️\n🐟🐠🐡皮卡鱼为您加油！🦈🎏🐬🐳🐋",
                "🔥🔥Lưu Bá Thiên cổ vũ bạn!🔥🔥🔥\n☁️☁️Kho mây cổ vũ bạn!☁️☁️\n🐟🐠🐡Pikafish cổ vũ bạn!🦈🎏🐬🐳🐋");
        VI.put("🎉 恭喜解锁隐藏题库！", "🎉 Chúc mừng đã mở khóa kho câu hỏi ẩn!");
        VI.put("开始挑战", "Bắt đầu thử thách");
        VI.put("开始练习 🚀", "Bắt đầu luyện tập 🚀");

        // ==================== AnalyzeActivity ====================
        VI.put("已重置局面", "Đã đặt lại thế cờ");
        VI.put("红方胜利！", "Đỏ thắng!");
        VI.put("初始局面", "Thế cờ ban đầu");
        VI.put("云库\n", "Kho mây\n");
        VI.put("绝杀\n", "Chiếu bí\n");
        VI.put("困毙\n", "Bí nước\n");
        VI.put("未找到该局面\n", "Không tìm thấy thế cờ này\n");
        VI.put("云库：查询失败", "Kho mây: Truy vấn thất bại");
        VI.put("分析", "Phân tích");
        VI.put("停止", "Dừng");
        VI.put("启动中...", "Đang khởi động...");
        VI.put("绝杀（%d步杀）", "Chiếu bí (%d nước)");
        VI.put("被绝杀（%d步杀）", "Bị chiếu bí (%d nước)");
        VI.put("分数：%d分", "Điểm: %d");
        VI.put("%d层", "%d tầng");
        VI.put("🐟🐠🐡皮卡鱼🦈🎏🐬🐳🐋", "🐟🐠🐡Pikafish🦈🎏🐬🐳🐋");
        VI.put("🐟 🐠 🐡 皮卡鱼为您加油！🦈 🎏 🐬 🐳 🐋", "🐟 🐠 🐡 Pikafish cổ vũ bạn!🦈 🎏 🐬 🐳 🐋");
        VI.put("<font color='#000000'><b>🐟🐠🐡皮卡鱼🦈🎏🐬🐳🐋</b></font><br/>", "<font color='#000000'><b>🐟🐠🐡Pikafish🦈🎏🐬🐳🐋</b></font><br/>");
        VI.put("<font color='#1F6128'><b>🐟🐠🐡皮卡鱼🦈🎏🐬🐳🐋</b></font><br/><br/>🐟 🐠 🐡 皮卡鱼为您加油！🦈 🎏 🐬 🐳 🐋",
                "<font color='#1F6128'><b>🐟🐠🐡Pikafish🦈🎏🐬🐳🐋</b></font><br/><br/>🐟 🐠 🐡 Pikafish cổ vũ bạn!🦈 🎏 🐬 🐳 🐋");
        VI.put("<div style='text-align:center'><font color='#1F6128'><b>🐟🐠🐡皮卡鱼🦈🎏🐬🐳🐋</b></font></div>",
                "<div style='text-align:center'><font color='#1F6128'><b>🐟🐠🐡Pikafish🦈🎏🐬🐳🐋</b></font></div>");

        // ==================== ChineseRules ====================
        VI.put("红方长将判负", "Đỏ chiếu tướng liên tục, xử thua");
        VI.put("黑方长将判负", "Đen chiếu tướng liên tục, xử thua");
        VI.put("红方长捉判负", "Đỏ bắt quân liên tục, xử thua");
        VI.put("黑方长捉判负", "Đen bắt quân liên tục, xử thua");
        VI.put("重复局面判和", "Thế cờ lặp lại, xử hòa");
        VI.put("双方长将判和", "Hai bên chiếu tướng liên tục, xử hòa");
        VI.put("双方长捉判和", "Hai bên bắt quân liên tục, xử hòa");
        VI.put("60回合无吃子判和", "60 nước không ăn quân, xử hòa");
        VI.put("无攻击子力判和", "Không còn lực lượng tấn công, xử hòa");

        // ==================== PositionValidator ====================
        VI.put("棋盘为空", "Bàn cờ trống");
        VI.put("存在未知棋子类型: %d", "Có loại quân không xác định: %d");
        VI.put("棋子总数超过32个", "Tổng số quân vượt quá 32");
        VI.put("红帅数量不合法(%d)", "Số lượng Tướng Đỏ không hợp lệ (%d)");
        VI.put("黑将数量不合法(%d)", "Số lượng Tướng Đen không hợp lệ (%d)");
        VI.put("红仕超过2个", "Số Sĩ Đỏ vượt quá 2");
        VI.put("黑士超过2个", "Số Sĩ Đen vượt quá 2");
        VI.put("红相超过2个", "Số Tượng Đỏ vượt quá 2");
        VI.put("黑象超过2个", "Số Tượng Đen vượt quá 2");
        VI.put("红马超过2个", "Số Mã Đỏ vượt quá 2");
        VI.put("黑马超过2个", "Số Mã Đen vượt quá 2");
        VI.put("红车超过2个", "Số Xe Đỏ vượt quá 2");
        VI.put("黑车超过2个", "Số Xe Đen vượt quá 2");
        VI.put("红炮超过2个", "Số Pháo Đỏ vượt quá 2");
        VI.put("黑炮超过2个", "Số Pháo Đen vượt quá 2");
        VI.put("红兵超过5个", "Số Tốt Đỏ vượt quá 5");
        VI.put("黑卒超过5个", "Số Tốt Đen vượt quá 5");
        VI.put("红帅不在九宫格", "Tướng Đỏ không ở trong cung");
        VI.put("黑将不在九宫格", "Tướng Đen không ở trong cung");
        VI.put("红仕不在九宫格", "Sĩ Đỏ không ở trong cung");
        VI.put("黑士不在九宫格", "Sĩ Đen không ở trong cung");
        VI.put("红仕位置非法", "Vị trí Sĩ Đỏ không hợp lệ");
        VI.put("黑士位置非法", "Vị trí Sĩ Đen không hợp lệ");
        VI.put("红相过河", "Tượng Đỏ vượt sông");
        VI.put("黑象过河", "Tượng Đen vượt sông");
        VI.put("红相位置非法", "Vị trí Tượng Đỏ không hợp lệ");
        VI.put("黑象位置非法", "Vị trí Tượng Đen không hợp lệ");
        VI.put("红兵未过河却在非法位置(row%d)", "Tốt Đỏ chưa qua sông nhưng ở vị trí không hợp lệ (hàng %d)");
        VI.put("红兵未过河不能横走(col%d)", "Tốt Đỏ chưa qua sông không được đi ngang (cột %d)");
        VI.put("黑卒未过河却在非法位置(row%d)", "Tốt Đen chưa qua sông nhưng ở vị trí không hợp lệ (hàng %d)");
        VI.put("黑卒未过河不能横走(col%d)", "Tốt Đen chưa qua sông không được đi ngang (cột %d)");
        VI.put("将帅照面(飞将)", "Hai Tướng đối mặt (Tướng bay)");

        // ==================== PikafishEngine ====================
        VI.put("引擎未就绪", "Engine chưa sẵn sàng");
        VI.put("引擎输出流关闭", "Luồng đầu ra của engine đã đóng");
        VI.put("进程退出(exitCode=%d): %s", "Tiến trình thoát (exitCode=%d): %s");
        VI.put("(无错误输出)", "(không có đầu ra lỗi)");
        VI.put("linker执行后进程退出(%d):%s", "Tiến trình thoát sau khi chạy qua linker (%d):%s");
        VI.put("shell执行后进程退出(%d):%s", "Tiến trình thoát sau khi chạy qua shell (%d):%s");
        VI.put("无法执行引擎二进制:\n方法1(直接): %s\n方法2(linker): %s\n方法3(shell): %s",
                "Không thể chạy tệp nhị phân của engine:\nCách 1 (trực tiếp): %s\nCách 2 (linker): %s\nCách 3 (shell): %s");
        VI.put("assets/Engine/pikafish-armv8 未找到!\n请确认文件位于:\napp/src/main/assets/Engine/pikafish-armv8\n注意: 不要用 .so 格式!",
                "Không tìm thấy assets/Engine/pikafish-armv8!\nVui lòng kiểm tra tệp tại:\napp/src/main/assets/Engine/pikafish-armv8\nLưu ý: không dùng định dạng .so!");
        VI.put("writer 为空", "writer rỗng");
        VI.put("(读取stderr失败: %s)", "(đọc stderr thất bại: %s)");
        VI.put("等待 '%s' 超时 (%dms)", "Hết thời gian chờ '%s' (%dms)");
        VI.put("引擎输出流提前关闭，未收到 '%s'", "Luồng đầu ra của engine đóng sớm, chưa nhận được '%s'");

        // ==================== 题库 / 适配器 / 错题本 ====================
        VI.put("序号 %d", "STT %d");
        VI.put("删除错题", "Xóa câu sai");
        VI.put("确定删除第 %d 题吗？", "Bạn có chắc muốn xóa câu %d không?");
        VI.put("剪贴板为空", "Clipboard trống");
        VI.put("内容为空", "Nội dung trống");
        VI.put("添加了 %d 条错题", "Đã thêm %d câu sai");
        VI.put("错题本为空", "Sổ câu sai trống");
        VI.put("已复制 %d 条错题", "Đã sao chép %d câu sai");

        // 内置题库名称（内部仍使用中文名作为键，界面显示越南语）
        VI.put("错题本", "Sổ câu sai");
        VI.put("象棋杀着大全", "Sát chiêu cờ tướng");
        VI.put("连将杀一至四步杀", "Liên sát 1-4 nước");
        VI.put("连将杀五至七步杀", "Liên sát 5-7 nước");
        VI.put("竹子涨棋", "Trúc Tử tăng kỳ");
        VI.put("屠景明-实用残局（一）", "Đồ Cảnh Minh - Tàn cục thực dụng (1)");
        VI.put("屠景明-实用残局（二）", "Đồ Cảnh Minh - Tàn cục thực dụng (2)");
        VI.put("武震-中级实用残局", "Vũ Chấn - Tàn cục thực dụng trung cấp");
        VI.put("武震-初级实用残局", "Vũ Chấn - Tàn cục thực dụng sơ cấp");
        VI.put("武震-高级实用残局", "Vũ Chấn - Tàn cục thực dụng cao cấp");
        VI.put("陈松顺-实用残局增订本", "Trần Tùng Thuận - Tàn cục thực dụng bản bổ sung");
        VI.put("夏老大-第1阶段练习（初）", "Hạ Lão Đại - Giai đoạn 1 (Sơ cấp)");
        VI.put("夏老大-第2阶段练习（中）", "Hạ Lão Đại - Giai đoạn 2 (Trung cấp)");
        VI.put("夏老大-第3阶段练习（高）", "Hạ Lão Đại - Giai đoạn 3 (Cao cấp)");
    }
}
