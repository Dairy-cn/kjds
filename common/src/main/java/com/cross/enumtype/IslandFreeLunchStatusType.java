package com.cross.enumtype;

/**
 * @author wy
 * @descrption 通吃岛霸王餐活动状态  Draft:草稿  UnStart:未开始  Signing:报名中  WaitResult:待开奖 HaveResult:已开奖  Ended:已终止  Lose:未中奖  WAIT_PUBLIC:已开奖,但未公布
 * @date 2019-8-7.
 */
public enum IslandFreeLunchStatusType {
    /**
     * 后台-草稿
     */
    DRAFT,
    /**
     * 未开始
     */
    UNSTART,
    /**
     * 报名中
     */
    SIGNING,
    /**
     * 待开奖
     * */
    WAIT_RESULT,
    /**
     * 已开奖
     */
    HAVE_RESULT,
    /**
     * 未中奖
     */
    LOSE,
    /**
     * 已终止
     */
    ENDED,
    /**
     * 已开奖,但未公布
     */
    HAVE_RESULT_WAIT_PUBLIC,
    /**
     * 未中奖,但未公布
     */
    LOSE_WAIT_PUBLIC,
    /**
     * 订单已生成
     */
    HAVE_ORDER,
    /**
     * 中台-草稿
     */
    MIDDLE_DRAFT,
    /**
     * 审核
     */
    AUDIT,
    /**
     * 撤回
     */
    CANCEL,
    /**
     * 撤销
     */
    REVOKE,
    /**
     * 取消撤销操作
     */
    CANCEL_REVOKE,
    /**
     * 撤销成功
     */
    CANCEL_SUCCESS,
    /**
     * 撤销失败
     */
    CANCEL_FAIL,
    /**
     * 拒绝
     */
    REJECT
}
