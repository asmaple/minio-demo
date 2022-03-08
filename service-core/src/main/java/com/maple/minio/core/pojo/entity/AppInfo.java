package com.maple.minio.core.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ggq
 * @since 2022-03-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="AppInfo对象", description="")
public class AppInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "APP类型（0：Android  1：IOS）")
    private Integer type;

    @ApiModelProperty(value = "是否更新（0：不更新  1：更新）")
    private Boolean hasUpdate;

    @ApiModelProperty(value = "是否可忽略该版本（是否强制更新）（0： 可忽略，1：不可取消）")
    @TableField("is_ignorable")
    private Boolean ignorable;

    @ApiModelProperty(value = "版本号")
    private Integer versionCode;

    @ApiModelProperty(value = "版本名")
    private String versionName;

    @ApiModelProperty(value = "更新内容")
    private String updateContent;

    @ApiModelProperty(value = "Android（下载地址） IOS（AppStore连接）")
    private String downloadUrl;

    @ApiModelProperty(value = "删除标记（0:不可用 1:可用）")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
