using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace NearbyShop.Migrations
{
    public partial class addlikedshoptouser : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<Guid>(
                name: "ShopId",
                table: "User",
                nullable: true);

            migrationBuilder.CreateTable(
                name: "UserShop",
                columns: table => new
                {
                    shopId = table.Column<Guid>(nullable: false),
                    userId = table.Column<Guid>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_UserShop", x => new { x.shopId, x.userId });
                    table.ForeignKey(
                        name: "FK_UserShop_Shop_shopId",
                        column: x => x.shopId,
                        principalTable: "Shop",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_UserShop_User_userId",
                        column: x => x.userId,
                        principalTable: "User",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_User_ShopId",
                table: "User",
                column: "ShopId");

            migrationBuilder.CreateIndex(
                name: "IX_UserShop_userId",
                table: "UserShop",
                column: "userId");

            migrationBuilder.AddForeignKey(
                name: "FK_User_Shop_ShopId",
                table: "User",
                column: "ShopId",
                principalTable: "Shop",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_User_Shop_ShopId",
                table: "User");

            migrationBuilder.DropTable(
                name: "UserShop");

            migrationBuilder.DropIndex(
                name: "IX_User_ShopId",
                table: "User");

            migrationBuilder.DropColumn(
                name: "ShopId",
                table: "User");
        }
    }
}
